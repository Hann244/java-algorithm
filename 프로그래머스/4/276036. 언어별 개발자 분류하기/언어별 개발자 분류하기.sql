SELECT
    CASE
        WHEN (D.SKILL_CODE & (
            SELECT CODE
            FROM SKILLCODES
            WHERE NAME = 'Python'
        )) > 0
        AND EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'Front End'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        THEN 'A'

        WHEN (D.SKILL_CODE & (
            SELECT CODE
            FROM SKILLCODES
            WHERE NAME = 'C#'
        )) > 0
        THEN 'B'

        WHEN EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'Front End'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        THEN 'C'
    END AS GRADE,
    D.ID,
    D.EMAIL
FROM DEVELOPERS D
WHERE (D.SKILL_CODE & (
    SELECT CODE
    FROM SKILLCODES
    WHERE NAME = 'C#'
)) > 0
OR EXISTS (
    SELECT 1
    FROM SKILLCODES S
    WHERE S.CATEGORY = 'Front End'
      AND (D.SKILL_CODE & S.CODE) > 0
)
ORDER BY GRADE ASC, D.ID ASC;