package peaksoft.springbootlms.api;

import peaksoft.springbootlms.entity.Company;
import peaksoft.springbootlms.entity.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootlms.service.GroupService;

@Controller
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @GetMapping
    public String getAllGroup(Model model){
        model.addAttribute("groups", groupService.getAllGroups());
        return "getAllGroups";
    }
    @GetMapping("/new")
    public String createGroup(Model model){
        model.addAttribute("newGroup", new Group());
        return "createGroup";
    }
    @PostMapping("/save")
    public String saveGroup(@ModelAttribute("newGroup")Group group){
      groupService.saveCompany(group);
        return "redirect:/api/groups";
    }
    @GetMapping("/{id}/get")
    public String getGroup(@PathVariable Long id, Model model){
        model.addAttribute("updateGroup",groupService.getGroupById(id));
        return "updateGroup";
    }
    @PostMapping("/{id}/update")
    public String updateGroup(@PathVariable Long id, @ModelAttribute ("updateGroup ")Group group){
    groupService.updateGroup(id, group);
        return "redirect:/api/groups";
    }
    @GetMapping("/{id}/delete")
    public String deleteGroup(@PathVariable Long id){
       groupService.deleteGroup(id);
        return "redirect:/api/groups";
    }
}

