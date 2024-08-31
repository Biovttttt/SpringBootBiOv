package peaksoft.springbootlms.service.serviceImpl;

import peaksoft.springbootlms.entity.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springbootlms.repository.GroupRepository;
import peaksoft.springbootlms.service.GroupService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public void saveCompany(Group group) {
groupRepository.save(group);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                ()->new NoSuchElementException(
                        "Course with id"+id+"not found!"));
    }

    @Override
    public void deleteGroup(Long id) {
if (!groupRepository.existsById(id)) {
    groupRepository.deleteById(id);
}else {
    throw new NoSuchElementException(
            "Course with id"+id+"not found!");}
    }

    @Override
    public void updateGroup(Long id, Group newGroup) {
Group group=getGroupById(id);
group.setGroupName(newGroup.getGroupName());
group.setDescription(newGroup.getDescription());
groupRepository.save(group);
    }
}
