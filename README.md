# Project 1.5

## Instructions

1. clone the repository and change the working directory to inside the root folder
> git clone https://github.com/RevatureRobert/Project1.5-template.git
> 
> cd Project1.5-template

2. Install the archetype onto your local repository
> mvn install

3. Move into a directory where you want your project to be located.

4. Generate the new project
> mvn archetype:generate \
> -DarchetypeArtifactId="Project1.5" \
> -DarchetypeGroupId="dev.enterprise" \
> -DgroupId=< your group id > \
> -DartifactId=< your project id >

5. Your project should be created and have all the necessary files to begin your new project!

## Specs
- Remove the JDBC logic and refactor with Hibernate ORM.
- Add in servlets and host on Tomcat Server.
- Deploy to AWS using Elastic Beanstalk (optional)
