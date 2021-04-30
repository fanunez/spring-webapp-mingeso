pipeline {
	agent any
	tools{
	    nodejs "NodeJS"
    }
	environment{
	    CI = 'true'
	}
	stages {
		stage('Deployment') {
			steps {
			    dir("./App/client"){
			        echo "Installing Dependencies"
                    sh 'npm install'
			    }
			    dir("/var/lib/jenkins/workspace/Mingeso Proyecto"){
			        echo "Deploying Backend"
			        sh 'gradlew bootrun'
			    }
				sh 'npm start'
			}
		}
		stage('SonarQube analysis') {
    			steps {
				dir("/var/lib/jenkins/workspace/Mingeso Proyecto") { //nombre del proyecto en jenkins
					withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    					}
				}
			}
  		}
		stage('JUnit'){
			steps {
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    			dir("/var/lib/jenkins/workspace/Mingeso Proyecto") {
						sh './gradlew test'
					}
                		}
				dir("/var/lib/jenkins/workspace/Mingeso Proyecto/build/test-results/test") {
					junit '*.xml'
				}
			}
		}
		stage('End') {
			steps {
				echo "End"
			}
		}
	}
}