#### This is Spring Security implemented using JWT.

# Features
    - Korean comment line added!
    - Simple, basic implementation.
    - Using Restful api to connect with React.
    - Use MySQL for databases.

# Spring Security -완-

1. 세션 방식

    - 유저네임, 패스워드 로그인 정상 확인 후
    - 서버쪽 세션아이디 생성
    - 클라이언트 쿠키에 세션아이디를 응답
    - 클라이언트 -> 서버 요청할때마다 쿠키에 있는 세션아이디를 항상 들고 서버쪽으로 요청
      > 서버는 세션아이디가 유효한지 판단해서 유효하면 인증이 필요한 페이지로 권한을 줌

   한계 :
   사용자가 많을 경우 서버를 여러개 두게 되는데, 이 때 세션아이디는 최초 로그인 시도한 서버에만 저장됨.
   이후의 요청에서 다른 서버로 접근을 요청하면 그 서버엔 세션아이디 정보가 없기때문에 인증이 불가능함.
   > 해결방법:
   여러개의 서버들이 모두 하나의 데이터베이스에 세션아이디를 저장
   램에서 사용하지 않고 I/O를 이용해 정보를 불러오기 떄문에 처리속도가 엄청나게 느려짐
   이를 해결하기 위해 램에서 데이터베이스를 관리하는 redis(레디스)를 사용하기도 함


1. JWT 토큰 방식 : RSA방식을 사용하여 세션에 저장하지 않고 유효한지 판단 가능

    - 유저네임, 패스워드 로그인 정상 확인 후
    - JWT토큰을 생성
    - 클라이언트 쪽으로 JWT토큰을 응답해줌
    - 요청할때마다 JWT토큰을 가지고 요청
    - 서버는 JWT토큰이 유효한지 판단

