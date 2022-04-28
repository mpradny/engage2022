FROM registry.gitlab.com/pristo/engage2022/domino-docker:V1201_11222021prod

COPY *.ntf /local/notesdata/app.ntf

COPY ids/ /local/ids/

USER notes
ENV SetupAutoConfigure=1 SetupAutoConfigureParams=/local/ids/config.json