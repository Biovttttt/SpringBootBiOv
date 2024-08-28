package service;

import entity.Group;

import java.util.List;

public interface GroupService {
    void saveCompany (Group group);
    List<Group> getAllGroups();
    Group getGroupById(Long id);
    void deleteGroup(Long id);
    void updateGroup(Long id,Group newGroup);
}
