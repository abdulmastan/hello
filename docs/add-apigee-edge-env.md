
The below fragment represents an Apigee Edge Proxy for an environment. 

Substitute the below variables in the snippet below and add to the config.json file to add a new API Proxy bundle for the names enviroment 
${env_name} - Apigee Edge enviroment Name ex: dev, sit, uat 
demographics-api - the name of the api which should be the same a the artifactID in the pom.xml file 
${ecs-domain-name} - This is the domain on ClearDATA / SV that is to receive the request 
${api-version} - the version of the API to  Apigee Gateway 

```
   {
      "name": "${env_name}",
      "policies": [
        {
          "name": "Assign-Message-1.xml",
          "tokens": [
            {
              "xpath": "/AssignMessage/Set/Headers/Header[@name='ENV']",
              "value": "${env_name}"
            }
          ]
        },
        {
          "name": "assign-variable.xml",
          "tokens": [
            {
              "xpath": "/AssignMessage/AssignVariable/Value",
              "value": "demographics-api.${ecs-domain-name}"
            }
          ]
        },
        {
          "name": "spike_arrest_by_clientid.xml",
          "tokens": [
            {
              "xpath": "/SpikeArrest/Rate",
              "value": "200ps"
            }
          ]

        },
        {
          "name": "json_threat_protection.xml",
          "tokens": [
            {
              "xpath": "/JSONThreatProtection/ArrayElementCount",
              "value": "1"
            },
            {
              "xpath": "/JSONThreatProtection/ContainerDepth",
              "value": "1"
            },
            {
              "xpath": "/JSONThreatProtection/ObjectEntryCount",
              "value": "1"
            },
            {
              "xpath": "/JSONThreatProtection/ObjectEntryNameLength",
              "value": "1"
            },{
              "xpath": "/JSONThreatProtection/StringValueLength",
              "value": "1"
            }

          ]

        },
        {
          "name": "log_message.xml",
          "tokens": [
            {
              "xpath": "/MessageLogging/Syslog/Host",
              "value": "localhost"
            },
            {
              "xpath": "/MessageLogging/Syslog/Port",
              "value": "556"
            }
          ]

        }
      ],
      "proxies": [
        {
          "name": "default.xml",
          "tokens": [
            {
              "xpath": "/ProxyEndpoint/HTTPProxyConnection/BasePath",
              "value": "/${api-version}/demographics-api"
            }
          ]
        }
      ],
      "targets": [
        {
          "name": "default.xml",
          "tokens": [
            {
              "xpath": "/TargetEndpoint/HTTPTargetConnection/URL",
              "value": "https://demographics-api.${ecs-domain-name}/"
            }
          ]
        }
      ]
    }
```

A Sample is provided below 

${env_name} = dev
demographics-api = member
${ecs-domain-name} = ecsdev.<domain>.com
${api-version} = v1


```
   {
      "name": "dev",
      "policies": [
        {
          "name": "Assign-Message-1.xml",
          "tokens": [
            {
              "xpath": "/AssignMessage/Set/Headers/Header[@name='ENV']",
              "value": "dev"
            }
          ]
        },
        {
          "name": "assign-variable.xml",
          "tokens": [
            {
              "xpath": "/AssignMessage/AssignVariable/Value",
              "value": "member.ecsdev.<domain>.com"
            }
          ]
        },
        {
          "name": "spike_arrest_by_clientid.xml",
          "tokens": [
            {
              "xpath": "/SpikeArrest/Rate",
              "value": "200ps"
            }
          ]

        },
        {
          "name": "json_threat_protection.xml",
          "tokens": [
            {
              "xpath": "/JSONThreatProtection/ArrayElementCount",
              "value": "1"
            },
            {
              "xpath": "/JSONThreatProtection/ContainerDepth",
              "value": "1"
            },
            {
              "xpath": "/JSONThreatProtection/ObjectEntryCount",
              "value": "1"
            },
            {
              "xpath": "/JSONThreatProtection/ObjectEntryNameLength",
              "value": "1"
            },{
              "xpath": "/JSONThreatProtection/StringValueLength",
              "value": "1"
            }

          ]

        },
        {
          "name": "log_message.xml",
          "tokens": [
            {
              "xpath": "/MessageLogging/Syslog/Host",
              "value": "localhost"
            },
            {
              "xpath": "/MessageLogging/Syslog/Port",
              "value": "556"
            }
          ]

        }
      ],
      "proxies": [
        {
          "name": "default.xml",
          "tokens": [
            {
              "xpath": "/ProxyEndpoint/HTTPProxyConnection/BasePath",
              "value": "/v1/member"
            }
          ]
        }
      ],
      "targets": [
        {
          "name": "default.xml",
          "tokens": [
            {
              "xpath": "/TargetEndpoint/HTTPTargetConnection/URL",
              "value": "https://member.ecsdev.<domain>.com/"
            }
          ]
        }
      ]
    }
```
