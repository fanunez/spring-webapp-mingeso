pipeline {
	agent any
	stages {
		stage('Inicio') {
			steps {
				echo "Inicio"
			}
		}
		stage('SonarQube analysis') {
    			steps {
				dir("/var/lib/jenkins/workspace/mingeso") {
					withSonarQubeEnv('sonarqube') { // Will pick the global server connection you have configured
						sh 'chmod +x ./gradlew'
						sh './gradlew sonarqube'
    					}
				}
			}
  		}
		stage('JUnit'){
			steps {
				dir("/var/lib/jenkins/workspace/mingeso/build/test-results/test") {
					sh 'touch hola.xml'
					sh 'rm *.xml'
				}
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    			dir("/var/lib/jenkins/workspace/mingeso") {
						sh './gradlew test'
					}
                		}
				dir("/var/lib/jenkins/workspace/mingeso/build/test-results/test") {
					junit '*.xml'
				}
			}
		}
		stage('Fin') {
			steps {
				echo "Fin"
			}
		}
	}
}