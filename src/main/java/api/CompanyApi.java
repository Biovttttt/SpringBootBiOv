package api;

import entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CompanyService;

@Controller
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService;

@GetMapping
    public String getAllCompanies(Model model){
    model.addAttribute("companies", companyService.getAllCompanies());
        return "getAllCompanies";
    }
    @GetMapping("/new")
    public String createCompany(Model model){
    model.addAttribute("newCompany", new Company());
    return "createCompany";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute ("newCompany")Company company){
    companyService.saveCompany(company);
    return "redirect:/getAllCompanies";
    }
@GetMapping("/{id}/get")
    public String getCompany(@PathVariable Long id, Model model){
    model.addAttribute("updateCompany",companyService.getCompanyById(id));
  return "updateCompany";
}
@PostMapping("/{id}/update")
    public String updateCompany(@PathVariable Long id, @ModelAttribute ("updateCompany ")Company company){
companyService.updateCompany(id, company);
    return "redirect:/api/companies";
}
@GetMapping("/{id}/delete")
    public String deleteCompany(@PathVariable Long id){
companyService.deleteCompany(id);
    return "redirect:/api/companies";
}
}
