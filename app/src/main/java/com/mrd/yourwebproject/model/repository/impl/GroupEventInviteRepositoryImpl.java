/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEvents;
import com.mrd.yourwebproject.model.entity.GroupMember;
import com.mrd.yourwebproject.model.repository.GroupEventInviteRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEventInviteRepositoryImpl extends
		BaseHibernateJpaRepository<GroupEventInvite, String> implements GroupEventInviteRepository{
public List<GroupEventInvite> findByGroupCodeAndCategoryCodeAndEventCode(String groupCode, String memberCategoryCode, String eventCode){
	return (List<GroupEventInvite>)sessionFactory.getCurrentSession().createQuery("from GroupEventInvite gei where gei.groupCode = ? and gei.memberCategoryCode = ? and gei.groupEventCode= ?").setString(0, groupCode).setString(1, memberCategoryCode).setString(2, eventCode).list();}

public List<GroupEventInvite> findByGroupCodeAndEventCode(String groupCode,
		String eventCode) {
	return (List<GroupEventInvite>)sessionFactory.getCurrentSession().createQuery("from GroupEventInvite gei where gei.groupCode = ? and gei.groupEventCode= ?").setString(0, groupCode).setString(1, eventCode ).list();
}

public List<GroupEventInvite> findByGroupMember(GroupMember groupMember) {
	return	(List<GroupEventInvite>)sessionFactory.getCurrentSession().createQuery("from GroupEventInvite gei where gei.groupMember= :groupMember").setParameter("groupMember", groupMember).list();
}

public GroupEventInvite findByGroupMemberAndGroupEvent(GroupMember groupMember, GroupEvents groupEvent)
{
	return	(GroupEventInvite)sessionFactory.getCurrentSession().createQuery("from GroupEventInvite gei where gei.groupMember= :groupMember and gei.groupEventCode = :groupEventCode").setParameter("groupMember", groupMember).setParameter("groupEventCode", groupEvent.getEventCode()).uniqueResult();	
}

public GroupEventInvite findByGroupEventInviteCode(String groupEventInviteCode) {
	 return	(GroupEventInvite)sessionFactory.getCurrentSession().createQuery("from GroupEventInvite gei where gei.groupEventInviteCode= :groupEventInviteCode").setParameter("groupEventInviteCode", groupEventInviteCode).uniqueResult();
}
}
