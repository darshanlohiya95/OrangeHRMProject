pipeline {
    agent any

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Browser to execute tests')
        choice(name: 'OPERATINGSYSTEM', choices: ['WINDOWS', 'LINUX'], description: 'Operating System')
        choice(name: 'ENVIRONMENT', choices: ['qa', 'uat'], description: 'Target environment')
        string(name: 'TAGS', defaultValue: '@smoke', description: 'Cucumber tags')
        booleanParam(name: 'RUN_ON_GRID', defaultValue: false, description: 'Run tests on Selenium Grid')
    }

    environment {
        MAVEN_OPTS = "-Xmx1024m"
        GIT_REPO = "https://github.com/krahul1b/OrangeHRM.git"
    }

    stages {
        stage('Checkout Source Code') {
            steps {
                git branch: 'main', url: "${GIT_REPO}"   // change 'main' if repo uses 'master'
            }
        }

        stage('Build & Execute Tests') {
            steps {
                script {
                    def mvnCmd = "mvn clean test -Dbrowser=${params.BROWSER} -Dos=${params.OPERATINGSYSTEM} -Denvironment=${params.ENVIRONMENT} -Dcucumber.filter.tags=${params.TAGS} -DrunOnGrid=${params.RUN_ON_GRID}"
                    if (params.OPERATINGSYSTEM == 'WINDOWS') {
                        bat mvnCmd
                    } else {
                        sh mvnCmd
                    }
                }
            }
        }

        stage('Publish Cucumber Report') {
            steps {
                cucumber(
                    buildStatus: 'UNSTABLE',
                    reportTitle: 'OrangeHRM UI Test Report',
                    fileIncludePattern: '**/cucumber.json'
                )
            }
        }
    }

    post {
        failure { echo '❌ Test execution failed. Check logs and reports.' }
        success { echo '✅ Test execution completed successfully.' }
    }
}