pipeline {
  agent any
  stages{
    stage('Build'){
      steps{
        sh 'C:\Users\Admin\Downloads\maven\apache-maven-3.8.1\bin\mnn clean install'
      }
    }
    stage('Test'){
      steps{
        sh 'C:\Users\Admin\Downloads\maven\apache-maven-3.8.1\bin\mnn test'
      }
    }
  }
}
