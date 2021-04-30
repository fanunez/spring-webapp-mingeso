pipeline {
	agent any
	stages {
        stage('Init') {
            steps {
                echo "Init"
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
					touch 'test.xml'
					sh 'rm --f test.xml'
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