/* groovylint-disable-next-line CompileStatic */
job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell('npm install')
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
