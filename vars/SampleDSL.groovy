// vars/sampleDSL.groovy
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = jenkins_config
    body()

    node {
     stage ('hardware info'){
        echo ' step1'
        echo '################'
        echo jenkins_config.HW
      }
     stage ('config info') {
        echo 'stage 2'
        echo jenkins_config.P1
        echo 'stage 3 , Feb '
      }
     stage ('3rd stage ') {
        echo "stage 3"
            
        echo jenkins_config.Custom
        echo jnekins_config.Guest_name
        echo "before Guest"
        aa = math1.power1(3,3)
        println aa
        sayHello jenkins_config.Guest_name
      }
    }
}
