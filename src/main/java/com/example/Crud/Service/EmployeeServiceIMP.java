package com.example.Crud.Service;

import com.example.Crud.Entity.Employee;
import com.example.Crud.Entity.Projects;
import com.example.Crud.Repository.Employee_repo;
import com.example.Crud.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIMP implements EmployeeService{
    @Autowired
    Employee_repo emp;
    @Autowired
    ProjectRepository pro;
    @Override
    public int addEmployee(Employee employee) {
        emp.save(employee);
        return employee.getEid();

    }

    @Override
    public String RemoveEmployee(int eid) {


            emp.deleteById(eid);
            return "Deleted succesfully";





    }
    public String saveProjects(Projects projects,int EmployeeId)
    {
       Employee employee= emp.findById(EmployeeId).orElse(null);
        List<Projects>p=employee.getProjects();
        p.add(projects);
        employee.setProjects(p);
        projects.setEmployee(employee);

        emp.save(employee);
        return "succesfully added";

    }

    @Override
    public List<Projects> displayProjects(int eid) {
        Employee employee=emp.findById(eid).orElse(null);
        return employee.getProjects();
    }

    public boolean checking(Employee employee)
    {

        if(employee.getEname().isBlank()|| employee.getEdesignation().isBlank() || employee.getEsalary().isBlank())
        {
            return false;
        }
        else
        {
            System.out.println("METHOD IS CALLED");

        }
        return true;



    }

    @Override
    public String RemoveProject(int pid) {
        if(pro.findById(pid)!=null)
        {
            pro.deleteById(pid);
            System.out.println("deleted succesffylly");
            return "Deleted succesfully";

        }
        return "UNABLE TO FIND EMPLOYEE";

    }

    @Override
    public Projects SingleProject1(int projectId) {
        return pro.findById(projectId).orElse(null);

    }

    @Override
    public String updateProject(Projects projects) {
        Projects p= pro.findById(projects.getProjectId()).orElse(null);
        p.setProjectId(projects.getProjectId());
        p.setProjectName(projects.getProjectName());
        p.setSubmitionDate(projects.getSubmitionDate());


        pro.save(p);
        return "Successfully Updated";

    }


    @Override
    public Employee SearchEmployee(int eid) {
       return emp.findById(eid).orElse(null);

    }
    public Employee SingleEmployee(int eid)
    {
        return emp.findById(eid).orElse(null);
    }

    @Override
    public List<Employee> DisplayEmployess() {

        return emp.findAll();
    }
    public String UpdateEmployee(Employee e) {

        Employee employee= emp.findById(e.getEid()).orElse(null);
        employee.setEid(e.getEid());
        employee.setEname(e.getEname());
        employee.setEdesignation(e.getEdesignation());
        employee.setEsalary(e.getEsalary());

        emp.save(employee);
        return "Successfully Updated";

    }



}
