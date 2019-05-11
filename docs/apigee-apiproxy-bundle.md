# API Proxy  Bundle 


An API proxy is a bundle of configuration files that act as a managed facade for existing HTTP services. In 
support of creating a starter Proxy Bundle, Liquidhub has create a reference proxy bundle.  This is implemented via combination of 
the global proxy bundle + application proxy bundle 

- apiproxy
    - policies
        - assign_handle_cookies_accept.xml
        - assign_set_variables.xml
        - fault_accept_json_not_found.xml
        - fault_invalid_secret.xml
        - js_setup_splunk_vars.xml
        - json_threat_protection.xml
        - log_message.xml
        - quota_rate_limit.xml
        - rate_limit.xml
        - Script-External-Variables.xml
        - service_callout_kms.xml
        - spike_arrest_by_clientid.xml
        - verify_apikey_clientid.xml
        - verify_oauth_accesstoken.xml
        - xmltojson-1.xml
    - proxies
        - common-js-vars.flowfrag
        - common_cid_request_steps.flowfrag
        - common_logging_post_flow_steps.flowfrag
        - common_oauth_fault.flowfrag
        - default.xml
        - json_threat_protection.flowfrag
        - log_message.flowfrag
        - spike_arrest_and_quota.flowfrag
        - validation.flowfrag
        - verify_oauthtoken.flowfrag
        - xmltojson.flowfrag
    - resources
        - jsc
            - js_external_vars.js
            - js_setup_splunk_vars.js
    - targets
        - default.xml
    - CommonProxy.xml
   

Located @src/gateway/apiproxy

- policies
    - Assign-variable.xml
    - service_callout_check.xml
- proxies
    - default.xml
- targets
    - default.xml 
- artifactId.xml


Every api that is created using the version 1.1+ of the API archetype provides a config.json file. This file is used to 
inject app specific metadata to the proxy bundles 

Ref [apigee-edge-config-json.md] for details