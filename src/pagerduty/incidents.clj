(ns pagerduty.incidents
  "Implements the PagerDuty incidents API: \"http://developer.pagerduty.com/documentation/rest/incidents\""
  (:require [pagerduty.core :refer (api-call)]))

(defn incident
  "A convience function to build incidents which will be passed
   to update-incidents. Requires an incident ID.

   Optional parameters:
   :status, :escalation_level, :assigned_to_user, :escalation_policy

   See: pagerduty.incidents/update-incidents"
  [id opts]
  (merge {:id id} opts))

;; TODO:
;; - incident_key not documented clearly
;; - it would be nice to have a :direction param for sort_by
(defn get-incidents
  "Return incidents which match the provided criteria.

   Optional parameters:
   :since, :until, :date_range, :fields, :status, :incident_key,
   :service,  :assigned_to_user, :time_zone, :sort_by"
  [& {:as opts}]
  (api-call :get "incidents" [] opts))

(defn get-incident
  "Return the details of a specific incident by passing its ID."
  [id & {:as opts}]
  (api-call :get "incidents/%s" [id] opts))

(defn count-incidents
  "Return the count of incidents which match the specified criteria.

   Optional parameters:
   :since, :until, :date_range, :status, :incident_key,
   :service, and :assigned_to_user"
  [& {:as opts}]
  (api-call :get "incidents/count" [] opts))

(defn acknowledge-incident
  "Acknowledge a specific incident by passing its ID.

  Optional parameters:
  :requester_id"
  [id & {:as opts}]
  (api-call :put "incidents/%s/acknowledge" [id] opts))

(defn resolve-incident
  "Resolve a specific incident by passing its ID.

   Optional parameters:
   :requester_id"
  [id & {:as opts}]
  (api-call :put "incidents/%s/resolve" [id] opts))

(defn reassign-incident
  "Reassign a specific incident by passing its ID.

   Optional parameters:
   :requester_id, :escalation_level, :assigned_to_user"
  [id & {:as opts}]
  (api-call :put "incidents/%s/reassign" [id] opts))

(defn update-incidents
  "Takes a collection of incidents and updates them.

   See: pagerduty.incidents/incident"
  [incidents-coll & {:as opts}]
  (api-call :put "incidents" [] (merge {:incidents incidents-coll} opts)))
