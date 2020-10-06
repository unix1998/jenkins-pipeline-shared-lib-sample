// vars/sampleDSL.groovy
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
      //  agent { label 'build-server' }

        stages {
            stage('Initialization') {
                steps {
                    script {
                       echo "initialization"
                    }
                }
            }
            stage('CI') {
                steps{
                    script{
                        gitCheckout{
                            repoUrl = config.repoUrl
                            credentialsId = config.credentialsId
                            branches = config.branches
                            commit = config.commit
                            echo (config.branches)
                        }
                    }
                }
            }
            stage('Service') {
            echo "Start docker service"
          }
        }
    }
}