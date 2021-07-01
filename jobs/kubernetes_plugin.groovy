multibranchPipelineJob('kubernetes-plugin') {
  branchSources {
    branchSource {
      source {
        git {
          // https://issues.jenkins.io/browse/JENKINS-48571
          id('Jenkins-Sample-Job') // IMPORTANT: use a constant and unique identifier
          remote('https://github.com/zhan9san/Jenkins-Sample-Job')
          traits {
            gitBranchDiscovery()
          }
        }
      }
      strategy {
        allBranchesSame {
          props {
            suppressAutomaticTriggering()
          }
        }
      }
    }
  }
  factory {
    workflowBranchProjectFactory {
      scriptPath('kubernetes-plugin/Jenkinsfile')
    }
  }
}
