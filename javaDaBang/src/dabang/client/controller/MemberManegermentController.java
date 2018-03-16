package dabang.client.controller;

import dabang.client.model.Member;

public class MemberManegermentController {

	
private void memberload()
	{
		
	Object [][] data = new Object[99][11];
    Member testMem [] = new Member[15];
    testMem[0] = new Member();
    testMem[1] = new Member();
    testMem[2] = new Member();
    testMem[3] = new Member();
    testMem[4] = new Member();
    testMem[5] = new Member();
    testMem[6] = new Member();
    testMem[7] = new Member();
    testMem[8] = new Member();
    testMem[9] = new Member();
    testMem[10] = new Member();
    testMem[11] = new Member();

    data[0] = new Object[11];//초기화시작
    data[1] = new Object[11];
    data[2] = new Object[11];
    data[3] = new Object[11];
    data[4] = new Object[11];
    data[5] = new Object[11];
    data[6] = new Object[11];//초기화끝

   for(int i=0;i<data.length;i++) 
    {
    	data[i][0] =testMem[i].getId();
    	data[i][1] =testMem[i].getNickName();
    	data[i][2] =testMem[i].getName();
    	data[i][3] =testMem[i].getSclc();
    	data[i][4] =testMem[i].getAgeY();
    	data[i][5] =testMem[i].getAgeD();
    	data[i][6] =testMem[i].getAgeM();
    	data[i][7] =testMem[i].getGender();
    	data[i][8] =testMem[i].getPhoneNumber();
    	data[i][9] =testMem[i].getGrade();
    	data[i][10] =testMem[i].getPoint();  									
    }

}
}
