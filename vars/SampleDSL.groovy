// vars/sampleDSL.groovy
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
     stage ('hardware info'){
        echo ' step1'
        echo '################'
        echo config.HW
      }
     stage ('config info') {
        echo 'stage 2'
        echo config.P1
        echo 'stage 3 , Feb '
      }
     stage ('3rd stage ') {
        echo "stage 3"
            
        echo config.Custom
        echo config.Guest_name
        sayHello config.Guest_name
      }
    }
}
