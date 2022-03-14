# BETTER WAY 03. 중복으로 저장된 데이터 항목을 제거하자

|ID|DrawingNumber|Predecessor1|Predecessor2|Predecessor3|Predecessor4|Predecessor5|
|---|---|---|---|---|---|---|
|1|Drawing1|1234|1234|3333|4444|5555|

위 예제의 테이블은 Predecessor 란 단일 속성이 반복 그룹임을 보여준다. <br>
또한, ID 가 1인 레코드에는 의도하지 않은 중복 값이 들어 있다. 

반복 그룹은 쿼리를 만들어 속성별로 묶은 보고서를 생성하기가 어렵다. <br>
나중에 Predecessor 값을 추가하거나 이미 있는 Predecessor 를 제거할 일이 생기면 테이블 수정이 일어나야 한다. <br>
또 이 테이블의 데이터를 기준으로 만든 모든 쿼리, 보고서의 설계도 수정해야 한다. 

> 영향도(비용) 측면에서 컬럼은 비싸고 로우는 싸다.

이 예제에서는 ID 값을 외래키로 사용하는 Predecessor 테이블을 생성하면 좋다. 

**Drawings** > DrawingID / DrawingNumber
**Predecessor** > PredecessorID / DrawingId / Predecessor

반복 그룹을 처리할 때는 **UNION 쿼리**를 사용한다. 

### UNION
> 쿼리의 결과를 합친다. 

```
SELECT name FROM professor UNION SELECT name FROM girl_group;
```

**유니온의 규칙**
1. 하나의 ORDER BY만 사용할 수 있다.
2. 각 SELECT의 열수, 표현식가 같아야 한다.
3. SELECT 문들 끼리 순서는 상관없다.
4. 유니온을 한 결과가 중복되면 하나만 나온다. (DEFAULT)
5. 열의 타입은 같거나 반환 가능한 형태여야 한다.
6. 중복값을 나타내고 싶다면 UNION ALL

