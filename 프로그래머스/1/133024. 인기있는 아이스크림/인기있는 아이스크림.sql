-- 아이스크림 맛을 총주문량 기준으로 내림차순 정렬
-- 주문량이 같으면  출하번호를 기준으로 오름차순 

-- 코드를 입력하세요
SELECT FLAVOR FROM FIRST_HALF

ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID;