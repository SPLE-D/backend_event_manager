#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE eventmanager_product_notifiedprivateeo' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'eventmanager_product_notifiedprivateeo') \gexec" | psql "postgresql://fathurrahman.kesuma:Finalsmash!102938@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://fathurrahman.kesuma:Finalsmash!102938@localhost/eventmanager_product_notifiedprivateeo"
done

java -cp eventmanager.product.notifiedprivateeo --module-path eventmanager.product.notifiedprivateeo -m eventmanager.product.notifiedprivateeo &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait