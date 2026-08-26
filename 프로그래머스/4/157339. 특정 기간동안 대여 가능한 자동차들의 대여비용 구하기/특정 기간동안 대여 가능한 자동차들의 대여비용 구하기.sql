SELECT CRCC.CAR_ID
    , CRCC.CAR_TYPE
    -- 1. 요금 계산식 수정: (100 - 할인율) 적용 및 정수 처리
    -- 💡 시니어의 박수: 소수점 오차를 막기 위해 (1 - 할인율/100) 대신 (100 - 할인율) / 100을 사용한 디테일이 아주 훌륭합니다.
    , ROUND(CRCC.DAILY_FEE * 30 * (100 - CRCDP.DISCOUNT_RATE) / 100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR CRCC
-- 2. HISTORY 테이블은 INNER JOIN에서 제거
-- 💡 핵심 포인트: 이 문제에서 HISTORY 테이블을 JOIN하면, 과거 대여 기록 개수만큼 데이터가 중복 생성되어 쿼리가 망가집니다. 과감히 분리한 판단이 100점입니다!
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN CRCDP
    ON CRCC.CAR_TYPE = CRCDP.CAR_TYPE 
    AND CRCDP.DURATION_TYPE LIKE '30%'
WHERE (CRCC.CAR_TYPE = '세단' OR CRCC.CAR_TYPE = 'SUV')
    -- 3. 11월 대여 기록이 "없는" 차량만 필터링 (NOT IN 사용)
    AND CRCC.CAR_ID NOT IN (
        SELECT CAR_ID 
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        -- 💡 전설의 날짜 오버랩 공식: "내 시작일 <= 기준 종료일 AND 내 종료일 >= 기준 시작일"
        -- 이 공식 하나로 11월에 단 하루라도 걸쳐있는 모든 기록을 완벽하게 잡아냈습니다!
        WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
    )
    -- 4. 서브쿼리를 안 쓰므로 SELECT의 계산식을 그대로 복사 (미만 조건 적용)
    AND ROUND(CRCC.DAILY_FEE * 30 * (100 - CRCDP.DISCOUNT_RATE) / 100) >= 500000 
    AND ROUND(CRCC.DAILY_FEE * 30 * (100 - CRCDP.DISCOUNT_RATE) / 100) < 2000000
-- 5. 문제 조건인 대여 요금 내림차순(FEE DESC) 추가
ORDER BY FEE DESC, CRCC.CAR_TYPE ASC, CRCC.CAR_ID DESC;