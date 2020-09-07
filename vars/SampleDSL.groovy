// vars/sampleDSL.groovy
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

   node ('master') {
      //  agent { label 'build-server' }

       
            stage('Initialization') {
                steps {
                    
                       echo "initialization"
                   
                }
            }
            stage('CI') {
                
                    echo ('test 2020 Sep sep')
             
            }
            stage('Service') {
            echo "Start docker service"
          }
        }
    
}
