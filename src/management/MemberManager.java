package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String, Member> membersMap;

    public MemberManager() {
        this.membersMap = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        String memberId = member.getMemberId();
        if(member == null || membersMap.containsKey(memberId)) {
            throw new IllegalArgumentException();
        }
        membersMap.put(memberId, member);
    }

    public Member getMember(String memberId) {
        return membersMap.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = getMember(memberId);
        if(member == null) {
            throw new IllegalArgumentException();
        }
        if(transaction == null) {
            throw new IllegalArgumentException();
        }
        member.addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        Member member = getMember(memberId);
        if(member == null) {
            throw new IllegalArgumentException();
        }
        return member.getLastTransaction();
    }
}