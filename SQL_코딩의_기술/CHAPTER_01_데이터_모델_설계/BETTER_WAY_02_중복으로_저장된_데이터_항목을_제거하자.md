# BETTER WAY 02. 중복으로 저장된 데이터 항목을 제거하자

데이터를 중복으로 저장하면 일관되지 않은 데이터, 비정상적인 삽입/갱신/처리 디스크 공간 낭비 등 많은 문제를 일으킨다. 

### 정규화 
> 중복 데이터를 저장하면서 일으키는 문제점을 없애려고 정보를 주제 별로 분할하는 프로세스 

여기서 말하는 '중복'은 어느 한 테이블의 기본키 값을 다른 테이블의 외래키로 사용하는 것이 아니다.<br>
그보다는 사용자가 동일한 데이터를 한 군데 이상에서 입력하는 상황에 더 가깝다. 

CustomerSales 라는 테이블을 예로 들어보자.

|SalesID|FirstName|LastName|Address|City|Phone|PurchaseDate|ModelYear|Model|SalesPerson|
|---|---|---|---|---|---|---|----|---|----|
|1|Amy|Bacock|1111 Dover Lane|Chicago|1111-1111-1111|2/14/2016|2016|Mercedes R333|Mariam Castor|
|2|Amy|Bacock|7435 Dover Lane|Chicago|1111-1111-1111|1/13/2018|2018|Land Rover|Jessica Robin|

여기서 Amy Bacock 의 주소가 1111, 7435 로 일치 하지 않는 것을 확인 할 수 있다. 

또한 이렇게 데이터가 비정규화 되어 있을 때 이름이 변경되는 경우 이 사람의 이름과 일치하는 모든 데이터를 갱신해줘야만 한다. 

CustomerSales 는 논리적으로 다음 테이블 네 개로 분할 할 수 있다. 

1. Customers 테이블(이름, 주소 등)
2. Employess 테이블(판매원 이름, 입사 일자 등)
3. AutomobileModels 테이블 (모델, 출시 연도 등)
4. SalesTransactions 테이블 

이렇게 설계하면 고객, 직원, 자동차 모델 정보는 각 테이블에 한 번만 입력해도 된다. 
