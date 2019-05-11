# Config.json 

This file holds the metadata is injected into a API proxy bundle before the firewall is deliver to the Apigee Gatweway. Deeveloper configure this file 
to make make changes to the metadata information . The metadata provided in this file is bundled in the API proxy bundle files which can be found @ 
target/classes/apiproxy. 

A sample config file is shown below.  As shown below the config file supports multiple environmentts, with each section providing the metatadata for the API proxy bundle. 
ex: All information in the "dev" section will be provied to the dev gateway in edge. 


```
{
  "configurations": [
   {"name": "dev"},
   {"name": "sit"},
   {"name": "stage"},
   {"name": "uat"}
   ]
}
```




Each section consisits of 3 parts 
1. Policies - These are the policies that are configurable via the config.json file  
2. Proxies - This section describes the URI that will be used to describe the service via the gateway. (ex: /v1/member) 
3. Targets - This section describes the location of the backend service (ex: https://member.ecsdev.<domain>.com)




Modifying the value this section allows teams to inject the environment level for their respective APIs. 

```
        {
          "name": "Assign-Message-1.xml",
          "tokens": [
            {
              "xpath": "/AssignMessage/Set/Headers/Header[@name='ENV']",
              "value": "${env_name}"
            }
          ]
        }
```


Modifying the value this section allows teams to setup the spike arrest level for their respective APIs. Set to '200ps' by default

```
          "name": "spike_arrest_by_clientid.xml",
          "tokens": [
            {
              "xpath": "/SpikeArrest/Rate",
              "value": "200ps"
            }
          ]

```


Modifying the value this section allows teams to setup the JSON Threat protection level for their respective APIs. Set to '1' by default

```
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
```



Modifying the value this section allows teams to redirect logs for their respective API Proxys. 

```
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
```



Modifying the value in this section allows teams to specify API URI in the Apigee Edge Portal. 

```
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
      ]
```


Modifying the value in this section allows teams to specify API backend server that should be sources from this source proxy bundle. 

```
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
```
