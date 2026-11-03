
-- 문제: 언어별 개발자 분류하기
-- 목표: 개발자가 보유한 스킬에 따라 A, B, C 등급을 부여한다.
--
-- A등급: Python + Front End 스킬을 모두 보유
-- B등급: C# 스킬을 보유
-- C등급: Front End 스킬을 보유
--
-- 주의: 여러 등급 조건을 만족할 수 있으므로
--       CASE WHEN에서 A → B → C 순서로 검사한다.

SELECT
    CASE
        -- [A등급]
        -- Python과 Front End 스킬을 모두 가지고 있어야 한다.
        WHEN (
            D.SKILL_CODE & (
                -- Python의 실제 스킬 코드를 조회한다.
                SELECT CODE
                FROM SKILLCODES
                WHERE NAME = 'Python'
            )
        ) > 0

        AND EXISTS (
            -- 개발자가 Front End 스킬을 하나라도 보유하는지 확인한다.
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'Front End'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        THEN 'A'

        -- [B등급]
        -- C# 스킬을 보유하고 있는지 확인한다.
        -- A등급 조건을 먼저 검사했으므로
        -- A와 B를 모두 만족하는 개발자는 A등급이 된다.
        WHEN (
            D.SKILL_CODE & (
                SELECT CODE
                FROM SKILLCODES
                WHERE NAME = 'C#'
            )
        ) > 0
        THEN 'B'

        -- [C등급]
        -- Front End 스킬을 하나라도 보유하고 있는지 확인한다.
        -- A, B에 해당하지 않는 개발자 중 Front End 보유자를 분류한다.
        WHEN EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'Front End'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        THEN 'C'

        -- 조건을 모두 만족하지 않으면 NULL
        -- (WHERE에서 제외하므로 ELSE는 생략 가능)
    END AS GRADE,

    D.ID,
    D.EMAIL

FROM DEVELOPERS D

-- A, B, C등급에 해당할 수 있는 개발자만 조회한다.
WHERE
    -- C#을 보유했거나
    (
        D.SKILL_CODE & (
            SELECT CODE
            FROM SKILLCODES
            WHERE NAME = 'C#'
        )
    ) > 0

    OR

    -- Front End 스킬을 하나라도 보유한 경우
    EXISTS (
        SELECT 1
        FROM SKILLCODES S
        WHERE S.CATEGORY = 'Front End'
          AND (D.SKILL_CODE & S.CODE) > 0
    )

-- 등급 오름차순 정렬
-- 같은 등급이라면 개발자 ID 오름차순 정렬
ORDER BY GRADE ASC, D.ID ASC;
