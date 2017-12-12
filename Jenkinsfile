node {
    def app
	
	
    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }


        stage ('Initialize') {
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
        }
		
	
	stage ('Build') {
                bat 'mvn install' 
        }

    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line 
		 app = docker.build("lam105/demopipe")*/

        bat 'docker build -t pipeline .'
    }

    stage('Push image') {
        /* Finally, we'll push the image with two tags:
         * First, the incremental build number from Jenkins
         * Second, the 'latest' tag.
         * Pushing multiple tags is cheap, as all the layers are reused. 
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }*/
		
		bat 'docker login --username=lam105 --password=hoidelamgi'
		bat 'docker push pipeline'
    }
}