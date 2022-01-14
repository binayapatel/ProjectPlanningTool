package com.pm.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.domain.Project;
import com.pm.services.MapValidationErrorService;
import com.pm.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationErrorService aMapValidationErrorService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
		
		ResponseEntity<Map<String,String>> validationErrorMsgMap = aMapValidationErrorService.getErrorMapMessage(result);
		if(validationErrorMsgMap != null) return validationErrorMsgMap;
		
		Project project1= projectService.saveOrUpateProject(project);
		return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
	}
	@GetMapping("/find/{projectid}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectid){
		Project project = projectService.findProjectByIndentifier(projectid);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	@GetMapping("/findAll")
	public ResponseEntity<?> getProjectById(){
		Iterable<Project> projects = projectService.findAll();
		return new ResponseEntity<Iterable<Project>>(projects,HttpStatus.OK);
	}
	@DeleteMapping("/findAll")
	public ResponseEntity<?> deleteProjectById(@PathVariable String projectid){
		boolean deleted = projectService.deleteByProjectIdentifier(projectid);
		return new ResponseEntity<Boolean>(deleted,HttpStatus.OK);
	}
}
