# 웹 프로그래밍 과외 교재

프로그래밍이 처음인 학습자를 위한 설치·기초 절차 보완판입니다.

## 교재 읽기

GitHub Pages 공개 주소: https://park-jongchul.github.io/studyWeb.html/studyWeb.html

Pages가 활성화된 뒤 위 주소에서 읽을 수 있습니다. 로컬에서는 저장소를 ZIP으로 내려받아 압축을 풀고 index.html을 엽니다.

- 교재 파일: [studyWeb.html](studyWeb.html)
- 공통 안내·참고 자료·예제: [study-materials](study-materials/)
- 각 장 끝의 혼자 해 보는 과제를 수행하고 결과 화면과 수정한 코드를 함께 제출하세요.
- 학습 완료 체크는 학습자의 브라우저에 저장되며 교수자에게 자동 전송되지 않습니다.

## 공유 설정

저장소 Settings → Pages → Deploy from a branch → main / (root) → Save.
배포 완료 뒤 위 공개 주소가 열리는지 확인합니다. GitHub 소스 주소와 교재를 읽는 Pages 주소는 서로 다릅니다.

## 검증 범위

웹 예제·목차·모바일 표시를 브라우저에서 검증했습니다. Android SDK 전체 앱 빌드와 Windows/Mac 설치 프로그램은 직접 실행하지 않았으며 설치 안내는 공식 문서와 대조했습니다.

## 추가 수업 · 2026-11-13

- [크롬 인스펙터 사용법](studyWeb.html#devtools): 열기, Elements, Styles, Console, 오류 수정, 모바일, Network 실습
- [VS Code에서 내 도메인에 반영](studyWeb.html#vscode-publish): Git 준비, 복제, Stage·Commit·Push, Pages 자동 배포 확인

## 학습 순서 보완 · 2026-11-15

개발자 도구 안내를 4장 앞으로 이동했습니다. 5장 첫 JavaScript 예제 전에 Console 사용·VS Code 파일 실행·Debug Console을 설명하고, 4장에는 모바일 우선 반응형 전체 파일 실습을 추가했습니다.

## 도메인·호스팅 설명 개편

17~20장을 기초 개념 → 무료 기본 주소 공개 → 도메인 등록 → DNS·Pages 연결 → VS Code Push 뒤 자동 배포 흐름으로 다시 작성했습니다. 20장에는 로컬·커밋·원격·호스팅 차이를 누르며 확인하는 학습용 모형과 VS Code 안에서 상태를 보는 방법이 있습니다.

## HTML·CSS 기초 전면 수정 · 2026-11-20

- HTML 14개 작은 수업: 태그·속성부터 문서·목록·그림·표·폼까지
- CSS 16개 작은 수업: p 선택자·문법·속성부터, 클래스는 마지막에 도입
- 실행 가능한 원본 실습 30개와 독립 HTML 파일
- 18~20장은 처음 한 번 주소 연결과 평소 VS Code 수정·푸시를 구분한 한 가지 경로로 단순화
- [입문 자료 11종의 본문 확인 범위](study-materials/06-HTML-CSS-입문자료-검토.html)
