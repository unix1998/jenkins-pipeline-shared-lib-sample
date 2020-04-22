// vars/sampleDSL.groovy
def call(body) {
    def jenkins_config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = jenkins_config
    body()

    node {
     stage ('hardware info'){
        echo ' step1'
        echo '################'
        echo jenkins_config.HW
         
        sh '''
        echo "GIT_PREVIOUS_SUCCESSFUL_COMMIT" : $GIT_PREVIOUS_SUCCESSFUL_COMMIT
        echo "GIT_PREVIOUS_SUCCESSFUL_COMMIT" : $GIT_PREVIOUS_SUCCESSFUL_COMMIT
        echo $GIT_PREVIOUS_SUCCESSFUL_COMMIT
        echo ${env.BRANCH_NAME}
        echo ${env.GIT_PREVIOUS_COMMIT}
        '''
        //def since1 = System.getenv('GIT_PREVIOUS_SUCCESSFUL_COMMIT') 
         def since1 = env.GIT_PREVIOUS_SUCCESSFUL_COMMIT
        println ('GIT_PREVIOUS_SUCCESSFUL_COMMIT')
        println(since1)
      }
     stage ('config info') {
        echo 'stage 2'
        echo jenkins_config.P1
        echo "stage 3 , March"
        def method11 = new Method1()
        method11.power2(2,3)
      }
     stage ('3rd stage ') {
        echo "stage 3"
            
        echo jenkins_config.Custom
        echo jenkins_config.Guest_name
        echo "before Guest"
        aa = math1.power1(3,3)
        println aa
        sayHello jenkins_config.Guest_name
      }
    }
}
