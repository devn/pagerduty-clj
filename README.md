# HEY, YOU.

# YEAH, YOU.

# DON'T USE THIS YET.

# IT'S NOT READY.

---

# PagerDuty API Client

A Clojure library for working with PagerDuty.

## Usage

Add it to your `project.clj`:

```clojure
(defproject yourproject
  :dependencies [[devn/pagerduty "0.1.0"]
                 ...])
```

Require it:

```clojure
(ns my-app.core
  (:require [pagerduty.incidents :refer :all]))
```

Use it:

```clojure
(with-defaults [token "MYTOKEN"
                subdomain "MYSUBDOMAIN"]
  (get-incidents :sort_by "created_on:desc"))
```

Note that I do not make any assumptions about how you intend to
provide your credentials.

## License

Copyright © 2013 Devin Walters

Distributed under the Eclipse Public License, the same as Clojure.
