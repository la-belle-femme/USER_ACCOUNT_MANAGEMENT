pipeline {
    agent any
    
    parameters {
        string(name: 'USERNAME', defaultValue: 'default_user', description: 'Enter a username')
        choice(name: 'ACTION', choices: ['create_user', 'delete_user', 'lock_user', 'unlock_user'], description: 'Select an action')
    }

    stages {
        stage('Print Jenkins Environment') {
            steps {
                script {
                    echo "Jenkins Environment:"
                    sh 'env'
                }
            }
        }

        stage('Perform Action') {
            steps {
                script {
                    echo "ACTION: ${params.ACTION}"
                    echo "USERNAME: ${params.USERNAME}"

                    if (params.ACTION == 'create_user') {
                        echo "Creating user ${params.USERNAME}"
                        // Add your command to create the user here
                    } else if (params.ACTION == 'delete_user') {
                        echo "Deleting user ${params.USERNAME}"
                        // Add your command to delete the user here
                    } else if (params.ACTION == 'lock_user') {
                        echo "Locking user ${params.USERNAME}"
                        // Add your command to lock the user here
                    } else if (params.ACTION == 'unlock_user') {
                        echo "Unlocking user ${params.USERNAME}"
                        // Add your command to unlock the user here
                    } else {
                        error "Invalid action: ${params.ACTION}"
                    }
                }
            }
        }
    }
}

