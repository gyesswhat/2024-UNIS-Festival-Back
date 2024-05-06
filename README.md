
# UNIS :: 2024 대동제 홈페이지

> UNIS 대동제 홈페이지 백엔드 레포지토리입니다.

<a href="https://docs.google.com/spreadsheets/d/1tEpwZgMzu_iFQC6BAYGZXBKJZvgFv2XsdHRnVcNun0A/edit?usp=sharing">![Static Badge](https://img.shields.io/badge/API%20%EB%AA%85%EC%84%B8%EC%84%9C-%23016FFB?style=for-the-badge)</a>
<a href="https://www.notion.so/unis-5th/DB-1e7d4f415f454c669234460c81a454ee?pvs=4">![Static Badge](https://img.shields.io/badge/DB%20%EC%84%A4%EA%B3%84-%23016FFB?style=for-the-badge)</a>
<a href="https://github.com/aoqlsdl/2024-UNIS-Festival-Front">![Static Badge](https://img.shields.io/badge/%ED%94%84%EB%A1%A0%ED%8A%B8%EC%97%94%EB%93%9C%20repo-%23016FFB?style=for-the-badge)</a>



## 🦕 Stacks

### Language & Framework
![Static Badge](https://img.shields.io/badge/java-%235382a1?style=for-the-badge&logoColor=white)
![Static Badge](https://img.shields.io/badge/spring%20boot-%236DB33F?style=for-the-badge&logo=springboot&logoColor=white)

### RDBMS
![Static Badge](https://img.shields.io/badge/mysql-%234479A1?style=for-the-badge&logo=mysql&logoColor=white) 

### Build
![Static Badge](https://img.shields.io/badge/gradle-%2302303A?style=for-the-badge&logo=gradle&logoColor=white)

### Deploy
![Static Badge](https://img.shields.io/badge/amazon%20ec2-%23FF9900?style=for-the-badge&logo=amazonec2&logoColor=white)
![Static Badge](https://img.shields.io/badge/amazon%20rds-%23527FFF?style=for-the-badge&logo=amazonrds&logoColor=white) ![Static Badge](https://img.shields.io/badge/amazon%20s3-%23569A31?style=for-the-badge&logo=amazons3&logoColor=white)
![Static Badge](https://img.shields.io/badge/amazon%20route%2053-%238C4FFF?style=for-the-badge&logo=amazonroute53&logoColor=white)


## 🦕 Folder Structure
```
src/main
├── java/com/example/liberewhaunis
│   ├── auth // 관리자 기능 
│   ├── reservation // 예약 기능 
│   ├── review // 리뷰 기능
│   ├── config // configuration
│   └── LiberewhaUnisApplication.java
└── resources
    └── application.properties
```

## 📘 Commit Convention
``` Markdown
<타입> : <제목>
ex) feat: 로그인 기능 추가

1. feat : 새로운 기능 추가
2. fix : 버그 수정
3. docs : 문서 수정
4. test : 테스트 코드 추가
5. refactor : 코드 리팩토링, 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우, 파일을 삭제하는 작업만 수행한 경우
6. chore : 코드 외 빌드 부분 혹은 패키지 매니저 수정사항

타입은 소문자로 고정
```
