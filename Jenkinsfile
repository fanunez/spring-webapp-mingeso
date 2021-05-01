pipeline {
	agent any
	environment{
	    scannerHome = tool 'SonarScanner 4.0';
	}
	stages {
        stage('Init') {
            steps {
                echo "Init"
            }
        }
		stage('SonarQube analysis') {
    			steps {
    			echo "sonarqube with Backend"
				dir("/var/lib/jenkins/workspace/MingesoProyectBackend") { //nombre del proyecto en jenkins
					withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
                    }
				}
				echo "sonarqube with Frontend"
				dir("/var/lib/jenkins/workspace/MingesoProyectFrontend"){
				    withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
				}
			}
  		}
		stage('JUnit'){
			steps {
			    dir("/var/lib/jenkins/workspace/MingesoProyectBackend/build/test-results/test") {
                    sh 'touch test.xml'
                    sh 'rm *.xml'
                }
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    			dir("/var/lib/jenkins/workspace/MingesoProyectBackend") {
						sh './gradlew test'
					}
                }
				dir("/var/lib/jenkins/workspace/MingesoProyectBackend/build/test-results/test") {
					junit '*.xml'
				}
			}
		}
		stage('End') {
            steps {
                echo "Deploying Backend"
            }
        }
	}
}