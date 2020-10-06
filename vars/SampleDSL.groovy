// vars/sampleDSL.groovy
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        stage ( 'input demo') {
              properties(
             [parameters([choice(choices: ["DEV", "UAT","QA". "PPROD","PROD"].join("\n"),
               description: 'choice parameter for build ', 
               name: 'my_CHOICE')])])
        }
     stage ('hardware info'){
        echo ' step1'
        echo '######my_CHOICE##########'
        echo my_CHOICE
        echo config.HW
        sh '''
        echo "GIT_PREVIOUS_SUCCESSFUL_COMMIT" : $IT_PREVIOUS_SUCCESSFUL_COMMIT
        echo "GIT_PREVIOUS_SUCCESSFUL_COMMIT" : $IT_PREVIOUS_SUCCESSFUL_COMMIT
        '''
      }
     stage ('config info') {
        echo 'stage 2'
        echo config.P1
        echo 'stage 3 , Feb '
      }
     stage ('3rd stage ') {
        echo 'stage 3'
            
        echo config.Custom
      }
    }
}
