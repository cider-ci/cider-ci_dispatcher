; Copyright (C) 2013, 2014, 2015 Dr. Thomas Schank  (DrTom@schank.ch, Thomas.Schank@algocon.ch)
; Licensed under the terms of the GNU Affero General Public License v3.
; See the "LICENSE.txt" file provided with this software.

(defproject cider-ci_dispatcher "3.0.0"
  :description "Cider-CI Dispatcher"
  :license {:name "GNU AFFERO GENERAL PUBLIC LICENSE Version 3"
            :url "http://www.gnu.org/licenses/agpl-3.0.html"}
  :dependencies [
                 [camel-snake-kebab "0.3.2"]
                 [cider-ci/clj-auth "3.1.0"]
                 [cider-ci/clj-utils "3.2.2"]
                 [drtom/honeysql "1.3.0-beta.3"]
                 [logbug "2.0.0-beta.6"]
                 [org.clojure/core.memoize "0.5.8"]
                 [org.clojure/tools.nrepl "0.2.11"]
                 ]
  :profiles {:dev
             {:dependencies [[midje "1.7.0"]]
              :plugins [[lein-midje "3.1.1"]]
              :repositories [["tmp" {:url "http://maven-repo-tmp.drtom.ch" :snapshots false}]]
              :resource-paths ["../config" "./config" "./resources"]}
             :production
             {:resource-paths ["/etc/cider-ci" "../config" "./config" "./resources"]}}
  :aot [cider-ci.dispatcher.main]
  :main cider-ci.dispatcher.main
  :repositories [["tmp" {:url "http://maven-repo-tmp.drtom.ch" :snapshots false}]]
  :jvm-opts ["-Xmx256m"]
  :repl-options {:timeout  120000}
  )
