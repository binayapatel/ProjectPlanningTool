package com.pm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.domain.Project;
import com.pm.exception.ProjectIdException;
import com.pm.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpateProject(Project project){
		try {
			project.setProjectIdentifier(project.getProjectIdentifier());
			return projectRepository.save(project);
		} catch (Exception exec) {
			throw new ProjectIdException("Project id '" + project.getProjectIdentifier() + "' already exist");
		}
	}

	public Project findProjectByIndentifier(String indentofier) {
		Project project = projectRepository.findByProjectIdentifier(indentofier);
		if(project == null) {
			throw new ProjectIdException("Project id '" + indentofier + "' not found");
		}
		return project;
	}

	public Iterable<Project> findAll() {
		return projectRepository.findAll();
	}

	public boolean deleteByProjectIdentifier(String projectid) {
		try {
			Project project = projectRepository.findByProjectIdentifier(projectid);
			projectRepository.delete(project);
			return true;
		}catch(Exception exec) {
			return false;
		}
	}
}
