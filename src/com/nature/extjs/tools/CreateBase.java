package com.nature.extjs.tools;

public class CreateBase
{
	protected String filePath;
	protected String className;
	protected String projectName;
	protected String author;

	public String getClassName()
	{
		return className;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}
}
