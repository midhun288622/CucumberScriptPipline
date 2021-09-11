pipeline {
    agent any
    stages {
        
        
        stage ('Test data preparation') 
        {

            steps {
                withMaven(maven : 'Maven setup') {
                
                    sh 'mvn test -Dcucumber.options="--tags @TestData"'
                    
                       }
                }
            
         }
         
    
       stage ("Change flght status") 
        {
            steps {
             script {
               env.EXECUTE = input message: 'User input required',
                              parameters: [choice(name: 'Is Flight cancelled ?', choices: 'Yes', description: '')]
                   
     
                  }
       
               }
         }
         
          stage ('Test Execution') 
        {

            steps {
                withMaven(maven : 'Maven setup') {
                
                    sh 'mvn clean install -Dcucumber.options="--tags @Sanity"'
                    
                       }
                }
            
         }
         
          stage ('Cucumber Reports') {

            steps {
                    cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'

            }
            }
     
   }
}