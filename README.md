"# myPage" 
1. 의뢰자는 분석 의뢰를 요청한다.

2. 의뢰를 취소한다.
3. 의뢰가 되면 접수를 한다.
4. 접수가 완료되면 의뢰서 상태를 변경한다.
5. 분석자는 분석을 진행하기 위해 분석 시작을 한다.
6. 분석을 시작하면 의뢰서 상태를 변경한다.
7. 분석을 완료하면 의뢰서 상태를 변경한다. 
8. 장비를 

9. 
비기능적 요구사항.

10. 
의뢰와 접수는 따로 분리되어있다.


cd ../../dev/kafka_2.13-2.5.0/bin/windows

git config --global core.autocrlf true
echo "# analysis" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/project-aircnc/analysis.git
git push -u origin master
                

https://github.com/project-aircnc/analysis.git
https://github.com/project-aircnc/request.git
https://github.com/project-aircnc/equipment.git
https://github.com/project-aircnc/myPage.git
