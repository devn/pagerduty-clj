# HEY, YOU.

# YEAH, YOU.

# DON'T USE THIS YET.

# IT'S NOT READY.

# SOON, THOUGH.

# SOON.

---

# PagerDuty Client

A Clojure library for working with PagerDuty.

## Usage

Add it to your `project.clj`:

```clojure
(defproject yourproject
  :dependencies [[devn/pagerduty "0.1.2"]
                 [org.clojure/clojure "1.5.1"]])
```

Require it:

```clojure
(ns my-app.core
  (:require [pagerduty.incidents :refer :all]
            [pagerduty.core :refer (set-subdomain! set-token!)]))
```

Try it from the REPL (`lein repl`):

```clojure
user> (require '[pagerduty.incidents :refer :all])
;; => nil

user> (require '[pagerduty.core :refer (set-subdomain! set-token!)])
;; => nil

user> (set-token! "YOURTOKEN")
;; => {:token "YOURTOKEN"}

user> (set-subdomain! "YOURSUBDOMAIN")
;; => "https://YOURSUBDOMAIN.pagerduty.com/api/v1/"

user> (get-incidents :sort_by "created_on:desc")
```

Note that I do not make any assumptions about how you intend to
provide your credentials.

## License

Copyright © 2013 Devin Walters

Distributed under the Eclipse Public License, the same as Clojure.
