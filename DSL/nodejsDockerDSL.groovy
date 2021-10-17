/* groovylint-disable-next-line CompileStatic */
job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/interactivedevelop/nodejsapp.git', 'master') { node ->
            node / gitConfigName('interactivedevelop')
            node / gitConfigEmail('sergi@systtekinteracyive.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejslatest')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('interactivedevelop/nodejsapp')
            /* groovylint-disable-next-line GStringExpressionWithinString */
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    // publishers {
    // slackNotifier {
    //         notifyAborted(true)
    //         notifyEveryFailure(true)
    //         notifyNotBuilt(false)
    //         notifyUnstable(false)
    //         notifyBackToNormal(true)
    //         notifySuccess(true)
    //         notifyRepeatedFailure(false)
    //         startNotification(false)
    //         includeTestSummary(false)
    //         includeCustomMessage(false)
    //         customMessage(null)
    //         sendAs(null)
    //         commitInfoChoice('NONE')
    //         teamDomain(null)
    //         authToken(null)
    //     }
    // }
}
