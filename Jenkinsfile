 def parameterFormat=""
 node {
   properties(
   
    [parameters([
    
    
        choice(choices: ["ecp-prelive", "capdev628", "capdev472"].join("\n"),description: 'Some choice parameter', name: 'test.environment'),
        string(name: 'branch', defaultValue: 'master', description: 'The target environment', ),
        string(name: 'outbound', defaultValue: '40', description: 'The targetSSS environment', ),
        string(name: 'test.options', defaultValue: '"--tags @Sanity"', description: 'The targetSSS environment', ),
        choice(choices: ["dektop", "tab", "mob"].join("\n"),description: 'Some choice parameter', name: 'test.device')
        
        ])
     ]
    

		)
   
     params.each {
     param ->
     println "${param.key} -> ${param.value} "
     def test12="-D${param.key}=${param.value} "
     parameterFormat=parameterFormat+test12
     }
 
}


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
