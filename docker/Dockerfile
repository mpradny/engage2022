FROM domino-docker:V1201_11222021prod

COPY target/*.ntf /local/notesdata/app.ntf

COPY docker/ids/ /local/ids/

USER notes
ENV SetupAutoConfigure=1 SetupAutoConfigureParams=/local/ids/config.json