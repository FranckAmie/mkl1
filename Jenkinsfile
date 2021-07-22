pipeline {
  agent any
  stages{
    stage('Build BUILD'){
      steps{
        sh 'mvn clean install'
      }
    }
   stage('Test TEST'){
        steps{
          sh 'mvn test'
        }
      }
  }
}
