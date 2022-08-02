# 4.2 @Table

엔티티와 매핑할 테이블을 지정한다. 

### 속성 정리 

|속성|기능|기본값|
|---|---|---|
|name|매핑할 테이블 이름|엔티티 이름 사용|
|catalog|catalog 기능이 있는 DB에서 catalog를 매핑한다.||
|schema|schema 기능이 있는 DB에서 schema를 매핑한다.||
|uniqueConstraints(DDL)|DDL 생성 시에 유니크 제약 조건을 만든다. 2개 이상의 복합 유니크 제약 조건도 만들 수 있다. 참고로 이 기능은 스키마 자동 생성 기능을 사용해서 DDL 을 만들 때만 사용된다.||