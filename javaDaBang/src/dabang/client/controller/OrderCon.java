package dabang.client.controller;

import java.util.ArrayList;

import dabang.client.model.Member;
import dabang.client.model.OrderList;

public class OrderCon {
	private ArrayList<ArrayList<OrderList>> al = new ArrayList<ArrayList<OrderList>>();
	private MemberController mCon = new MemberController();
	private Member m = new Member();
	public void addOrder(Member accessMember, ArrayList <OrderList> ol) {
	
		mCon.loadMember();
		al.add(ol);
		accessMember.setList(al);
		mCon.memberModify(accessMember);
		mCon.saveMember();
		
		mCon.loadMember();
		ArrayList <ArrayList<OrderList>>al1 = new ArrayList<ArrayList<OrderList>>();
		ArrayList <OrderList> al2 = new ArrayList<OrderList>();
		al1 = mCon.memberSelect(accessMember.getId()).getList();
		for(int i=0; i<al1.size();i++) {
			System.out.println(al1.get(i));
			System.out.println();
			al2 = al1.get(i);
			for(int j=0;j<al2.size();j++) {
				System.out.println(al2.get(j));
			}
		}
	}
}
